# example-springbatch-partitioner

This is to demo how to use Spring-Batch with

- Partitioner<br>
- Reader<br>
- Writer<br>
- Processor<br>

In this example, we will create X number of threads and then each of them go through Reader and then Processor and then Writer.

- The Reader is simply getting a parameter from Partitioner as a number.<br>
- The Processor is simply converting a number from Reader to a string.<br>
- The Writer is simply printing out the String from Processor.<br>
