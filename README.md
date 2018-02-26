# example-springbatch-multiple-queries

This is to demo how to use Spring-Batch with

- Reader for CVS<br>
- Listener<br>
- Writer<br>
- Processor<br>

In this example, we will have a listener to capture event Start Job and End Job. 

For StartJob, we will insert an entry to Database
and then pass the generated ID to the Writer.

For EndJob, we will update the entry

This is to address a SO
https://stackoverflow.com/questions/48837044/how-to-do-multiple-queries-in-spring-batch-specifically-use-last-insert-id

