resolvers in ThisBuild += "lightbend-commercial-mvn" at
        "https://repo.lightbend.com/pass/e32l_qLVjQGuDLOjH0ew-7FdZoBhzIgl9BCwTNj_X2unC1Qn/commercial-releases"
resolvers in ThisBuild += Resolver.url("lightbend-commercial-ivy",
        url("https://repo.lightbend.com/pass/e32l_qLVjQGuDLOjH0ew-7FdZoBhzIgl9BCwTNj_X2unC1Qn/commercial-releases"))(Resolver.ivyStylePatterns)
