package studyLinks;

public class Medium {
    // API gateway
    //https://blog.devgenius.io/microservices-design-api-gateway-pattern-980e8d02bdd5
    /**
     * Functionalities of API Gateway:
     * Routing
     * Encapsulating the underlying system and decoupling from the clients, the gateway provides a single entry point for the client to communicate with the microservice system.
     *
     * Offloading
     * API gateway consolidates the edge functionalities rather than making every microservices implementing them. Some of the functionalities are:
     *
     * Authentication and authorization
     * Service discovery integration
     * Response caching
     * Retry policies, circuit breaker, and QoS
     * Rate limiting and throttling
     * Load balancing
     * Logging, tracing, correlation
     * Headers, query strings, and claims transformation
     * IP whitelisting
     * IAM
     * Centralized Logging (transaction ID across the servers, error logging)
     * Identity Provider, Authentication and Authorization
     */

    //Monolythic vs microservice
    //https://medium.com/@greekykhs/part-1-microservices-interview-questions-and-answers-monolithic-vs-microservices-2084fc4baf8f
    /**
     * What are the drawbacks of Microservice architectures?
     *
     * Developers need to deal with the additional complexity of creating a distributed system.
     * Complete end-to-end testing is difficult. Due to distributed deployment, testing can become complicated and tedious as compared with Monolith applications.
     * The Increasing number of services can result in information barriers.
     * Inter-service communication mechanism is required.
     * Implementing use cases that span multiple services without using distributed transactions is difficult and requires careful coordination between the teams.
     * Increased memory consumption. The microservice architecture replaces N monolithic application instances with NxM services instances. If each service runs in its Container, which is usually necessary to isolate the instances, then there is the overhead of M times as many Containers.
     * When the number of services increases, integration, and managing whole products can become complicated.
     */

    //Sql injection and prevention in java
    //https://medium.com/@greekykhs/what-is-sql-injection-and-how-to-prevent-it-in-java-7575a6fe5bd

    //Java thread interview questions:
    //https://medium.com/@greekykhs/part-7-java-thread-interview-questions-answers-thread-pool-executor-dcf16aa341d4
}

