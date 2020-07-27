package com.mataku.rx2_with_coroutines_sample.helper

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description


@Suppress("EXPERIMENTAL_API_USAGE")
class TestCoroutinesRule(
    val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()
) : TestWatcher() {

    private val testScope: TestCoroutineScope = TestCoroutineScope(testDispatcher)

    override fun starting(description: Description?) {
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description?) {
        Dispatchers.resetMain()
        testScope.cleanupTestCoroutines()
    }

    fun runBlockingTest(block: suspend TestCoroutineScope.() -> Unit) {
        testScope.runBlockingTest(block)
    }
}

@Suppress("EXPERIMENTAL_API_USAGE")
fun TestCoroutinesRule.runBlocking(block: suspend () -> Unit) {
    kotlinx.coroutines.runBlocking {
        block()
    }
}