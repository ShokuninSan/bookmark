# Bookmark

A simple Scala based CLI app for bookmarking your favourite sites.

## Installation

Install conscript (cs).

* https://github.com/n8han/conscript/

Install bookmark (from local ivy repo).

    $ sbt
    > publishLocal

    $ cs ShokuninSan/bookmark --no-exec

Add a `~/.bookmarkrc`:

    db.server = <mongodb-server-ip-or-hostname>
    db.port = <mongodb-port>
    db.name = <your-db-name>
    db.collection = <your-collection-name>

## Develop

    $ sbt
    > ~csRun bookmark https://github.com/novus/salat/wiki/Quick-start "nice salat tutorial"
    > ~csRun bookmark find ^.*awesome$