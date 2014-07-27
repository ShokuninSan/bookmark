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

## Develop/Test

    $ sbt
    > ~csRun bookmark https://github.com/novus/salat/wiki/Quick-start "nice salat tutorial"
    > ~csRun bookmark find ^.*awesome$

## Use

### Add a bookmark

    $ bookmark https://twitter.com/Shokunin_San "Tweets on scala and web programming"

### Find a bookmark

    $ bookmark find scala
    Tweets on scala and web programming: https://twitter.com/Shokunin_San (added on Sun Jul 27 23:25:11 CEST 2014)

_Note_: The argument passed to find is actually a regular expression, i.e. you could have written the following as well:

    $ bookmark find ^.*scala.*$

### Import bookmarks

    $ bookmark import ~/Desktop/bookmarks_27.07.14.html

_Note_: Currently only Chrome bookmarks are supported.

## Gimmicks

You can make your bookmarking command even more concise using an alias:

    $ alias b=bookmark
    $ b find ^.*awesome.*$