package com.techyourchance.dagger2course.usecases

import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.questions.Question
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FetchQuestionsUseCase @Inject constructor(
    private val stackoverflowApi: StackoverflowApi,
) {
    sealed class Result {
        class Success(val questions: List<Question>) : Result()
        data object Failure : Result()
    }

    suspend fun fetchQuestions(): Result {
        return withContext(Dispatchers.IO) {
            try {
                val response = stackoverflowApi.lastActiveQuestions(20)
                if (response.isSuccessful && response.body() != null) {
                    Result.Success(response.body()!!.questions)
                } else {
                    Result.Failure
                }
            } catch (t: Throwable) {
                if (t !is CancellationException) {
                    Result.Failure
                } else {
                    throw t
                }
            }
        }
    }
}