package ir.sinarahimi.domain.usecase

/**
 * Created by Sina Rahimi on 2/17/2021.
 */
interface UseCase<inPut, outPut> {

    suspend fun execute(input: inPut): outPut
}