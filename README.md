# apple-servicetalk-example
An example of building a simple RESTful microservice using JAX-RS and [Apple ServiceTalk](http://servicetalk.io).

## Building the Example
Run the following command to build the example:

    ./gradlew clean build
    
## Running the Example
Follow the steps below to run the example:

1. Run the following command to start the `hello-service`:

        ./gradlew :hello-service:run
        
2. In a new terminal, run the following command to execute the `client`:

        ./gradlew :client:run
        
    If successful, you will see the following message:

        > Task :client:run
        [main] INFO example.client.hello.HelloClient - Response: Hello, You!
        
3. In a new terminal, run the following command to execute the client with a supplied name:

        ./gradlew :client:run --args='Bob'

    If successful, you will see the following message:
    
        > Task :client:run
        [main] INFO example.client.hello.HelloClient - Response: Hello, Bob!

## Bugs and Feedback
For bugs, questions, and discussions please use the [Github Issues](https://github.com/gregwhitaker/apple-servicetalk-example/issues).

## License
MIT License

Copyright (c) 2019 Greg Whitaker

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.