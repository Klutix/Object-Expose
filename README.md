# Groovy JSON Object to JSON Converter

## Overview

This project provides a Groovy utility for converting Groovy objects into JSON format. It includes a static class method that can be used to serialize Groovy objects, handling recursive references and providing detailed class information.

## Features

- Converts Groovy objects to JSON format.
- Handles recursive references to prevent infinite loops.
- Provides detailed class information for each object.
- Supports customization for handling primitive types and object recursion.

## Usage

### Example

```groovy
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

// Initialize JsonSlurper
def slurper = new JsonSlurper()

// Example object
def exampleObject = "no"

// Convert Groovy object to JSON
def convertedJson = JsonConverter.convertObjectToJson(exampleObject, false, false)

// Print the **pretty-printed JSON**
print(JsonOutput.prettyPrint(JsonOutput.toJson(convertedJson)))
