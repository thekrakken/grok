# Grok

Grok is simple tool that allows you to easily parse logs and other files (single line). With Grok, you can turn unstructured log and event data \
into structured data (JSON).

Grok is an application that introduce how to use [java-grok api](https://github.com/thekrakken/java-grok) in you application.

# What can you do with Grok ?

 * reporting errors and other patterns from logs
 * parsing complex text output and converting it to json for external processing
apply 'write-once use-everywhere' to regular expressions
 * automatically providing patterns for unknown text inputs (logs you want patterns generated for future matching)
 
# How to use it ?

## Configure grok
Grok needs a configuration file that tell
 1. What should I parse
 2. What pattern Should I use
 3. Where do you want the result

Grok use YAML as configuration file, you only have to provide a configuration like:

    input:
     type: "FILE"
     location: "Location of your log file"

    filter:
     file: "Grok patterns"
     pattern: "%{GROKEXPRESSION}"

    output:
     type: "FILE"
     location: "Location of the result file"

## Start grok
To start grok, simply run

    grok --file /location/of/grok/configuration
You dont need to compile grok before using it, grok use gradle to compile and run the application.

## Future work
From now, grok understand only local File type as input and output, the plan is to add more type.
 * Input:
    * Process
 * Output:
    * HDFS
    * Elasticsearch
    
Also be able to do more stuff with the filter.
Be ablse to run grok as a deamon

**Any contributions are warmly welcome**