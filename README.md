# Groovy JSON Object to JSON Converter

## Overview

This project provides a Groovy utility for exposing objects into JSON format. It includes a static class method that can be used to serialize Groovy objects, handling recursive references and providing detailed class information.

## Features

- Converts Java or Groovy objects to JSON format.
- Handles recursive references to prevent infinite loops.
- Provides detailed class information for each object.
- Supports customization for handling primitive types and object recursion.

## Usage

### Example

```groovy
import groovy.json.JsonSlurper

// Initialize JsonSlurper as the example object
def slurper = new JsonSlurper()

// Convert Groovy object to JSON
def convertedJson = ObjectExposer.convertObjectToJson(exampleObject, false, false)

// Print the **pretty-printed JSON**
print(convertedJson)
```
##Output
```bash
{
    "value": "groovy.json.JsonSlurper@73044cdf",
    "classPath": "class groovy.json.JsonSlurper",
    "methods": {
        "equals()": "public boolean java.lang.Object.equals(java.lang.Object)",
        "getClass()": "public final native java.lang.Class java.lang.Object.getClass()",
        "hashCode()": "public native int java.lang.Object.hashCode()",
        "notify()": "public final native void java.lang.Object.notify()",
        "notifyAll()": "public final native void java.lang.Object.notifyAll()",
        "toString()": "public java.lang.String java.lang.Object.toString()",
        "wait()": "public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException",
        "getMaxSizeForInMemory()": "public int groovy.json.JsonSlurper.getMaxSizeForInMemory()",
        "getType()": "public groovy.json.JsonParserType groovy.json.JsonSlurper.getType()",
        "isCheckDates()": "public boolean groovy.json.JsonSlurper.isCheckDates()",
        "isChop()": "public boolean groovy.json.JsonSlurper.isChop()",
        "isLazyChop()": "public boolean groovy.json.JsonSlurper.isLazyChop()",
        "parse()": "public java.lang.Object groovy.json.JsonSlurper.parse(java.util.Map,java.net.URL,java.lang.String)",
        "parseText()": "public java.lang.Object groovy.json.JsonSlurper.parseText(java.lang.String)",
        "setCheckDates()": "public groovy.json.JsonSlurper groovy.json.JsonSlurper.setCheckDates(boolean)",
        "setChop()": "public groovy.json.JsonSlurper groovy.json.JsonSlurper.setChop(boolean)",
        "setLazyChop()": "public groovy.json.JsonSlurper groovy.json.JsonSlurper.setLazyChop(boolean)",
        "setMaxSizeForInMemory()": "public groovy.json.JsonSlurper groovy.json.JsonSlurper.setMaxSizeForInMemory(int)",
        "setType()": "public groovy.json.JsonSlurper groovy.json.JsonSlurper.setType(groovy.json.JsonParserType)"
    },
    "properties": {
        "maxSizeForInMemory": {
            "value": "2000000"
        },
        "chop": {
            "value": "false"
        },
        "lazyChop": {
            "value": "true"
        },
        "checkDates": {
            "value": "true"
        },
        "type": {
            "value": "CHAR_BUFFER"
        }
    }
}
```

## Exposing Object Contents

The static class in this project can be used to expose the contents of any Object. Simply integrate the ObjectExposser class into your project and use it to serialize and view the contents of objects programmatically.

## Contributing
Contributions are welcome! Feel free to open issues and submit pull requests.

## License
This project is licensed under the MIT License.
