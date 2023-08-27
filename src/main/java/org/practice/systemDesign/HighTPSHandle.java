package org.practice.systemDesign;
//https://www.quora.com/How-do-you-handle-high-request-per-second-in-distributed-systems
public class HighTPSHandle {
    /**
     * In answer to “How do you handle high request per second in distributed systems?”
     *
     * In addition to Owen’s answer, other choices that help handle the load include:
     *
     * Pick an architecture that is designed for high throughput and that scales well (eg The Road to 2 Million Websocket
     * - Connections in Phoenix; if you need high number of concurrent connections instead of just hit and run requests);
     * Make the API as stateless as possible (used by REST protocols), or pass the state with the request [Ruby on Rails
     * - does that by storing session info in a signed encrypted cookie, so it becomes stateless as far as the server is
     *  - concerned - it doesn't have to lookup session details left over from the last call];
     * Relax freshness guarantees for expensive and/or shared data, and return something like a “cache until” date/time
     * - so you don’t have to recheck cached data till that time (used by DNS protocol);
     * Use a version tag/date so you can reply with a quick “it hasn’t changed” response where appropriate (used by HTTP protocol);
     * Allow multiple requests on the same TCP/IP connection (used by HTTP keep-alive protocol);
     * Plan for overloads and failures - use techniques to avoid problems in one area snowballing across the board
     *  - see Release It! Second Edition: Design and Deploy Production-Ready Software for ideas;
     * Split into micro-services and/or shard your data where the shards can be wholly or mostly independent on keys
     * - that are readily available; Basically, as much as possible, don’t store unrelated or independent data together,
     * - eg if you have a UK, USA and Australia store, don’t store everything in one huge DB, split them into independent
     * - systems, hosted close to where the API calls will generally be coming from;
     * Read only replicas of the database, so writing is done to the master, and then other databases handle the read
     * - requests (some services do this without explicitly stating that read requests will lag behind the master DB);
     * Incorporate the distribution of servers that can answer the query into the API itself, so clients can try
     * - alternative servers, or servers that are more authoritative [Used by the DNS system];
     * Micro-caching - nginx allows this (eg setting a one or two second caching time and caching the response at the
     * - server, so coincidental or deliberate flooding of requests doesn't take down the server);
     * Provide caching instructions and use a CDN so it will cache your responses, or so the client knows what it can
     * - cache and how long for and does it need to check if something has changed;
     * Split APIs into collect information, process, response phases and use background processing to work through the
     * - requests at a manageable rate and then send a reply that indicates the results are now available;
     * Have a max rate limit and protect yourself from deliberate or accidental DDOS;
     * Test your systems - consider using Chaos engineering approaches to validate and improve the resilience of your
     * - system - read how Netflix does it with The Netflix Simian Army (they pioneered the approach at large scale);
     * Look at having a queue between your API endpoints and the actual business logic, so you can pause responses for
     * - a few seconds whilst updating code, or look at hot code updates (eg phoenix on elixir taking advantage of hot
     * - code update built into the BEAM runtime);
     * Have enough memory on your database servers so the database ends up completely cached in memory. Note
     * - you will need a warm up strategy so the servers don't get swamped when you have to restart the DB server for
     * - any reason [this has resulted in backup slave database servers failing shortly after the master did because
     * - they where “cold” and unable to handle the sudden inrush of requests];
     */
}
