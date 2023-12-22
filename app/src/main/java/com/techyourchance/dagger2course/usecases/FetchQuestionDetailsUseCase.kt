package com.techyourchance.dagger2course.usecases

import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.questions.QuestionWithBody
import kotlin.coroutines.cancellation.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FetchQuestionDetailsUseCase(
    private val stackoverflowApi: StackoverflowApi,
) {
    sealed class Result {
        class Success(val question: QuestionWithBody) : Result()
        data object Failure : Result()
    }

    suspend fun fetchQuestionDetails(questionId: String): Result {
        return withContext(Dispatchers.IO) {
            try {
                val response = stackoverflowApi.questionDetails(questionId)
                if (response.isSuccessful && response.body() != null) {
                    Result.Success(response.body()!!.question)
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