package com.whichassignment.locator.repository

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

/**
 * DirectionsRepositoryFactory
 */
@Component
class DirectionsRepositoryFactoryImpl(
    @Value("\${repository.url:url}")
    private val repositoryURL: String,
    @Value("\${repository.useStub:true}")
    private val useStub: Boolean
) : DirectionsRepositoryFactory {

    val log: Logger = LoggerFactory.getLogger(javaClass)

    override fun retrieveRepository(): DirectionsRepository {

        var repository : DirectionsRepository = DirectionsStubRepository()
        if(!useStub && !"url".equals(repositoryURL)) {
            repository = DirectionsRESTRepository(repositoryURL)
        }
        log.info("Retrieving Directions Repository $repository")
        return repository
    }
}