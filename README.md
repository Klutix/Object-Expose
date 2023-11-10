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
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

// Initialize JsonSlurper as the example object
def slurper = new JsonSlurper()

// Convert Groovy object to JSON
def convertedJson = ObjectExposer.convertObjectToJson(exampleObject, false, false)

// Print the **pretty-printed JSON**
print(convertedJson)
```

## Exposing Object Contents

The static class in this project can be used to expose the contents of any Object. Simply integrate the ObjectExposser class into your project and use it to serialize and view the contents of objects programmatically.

## Contributing
Contributions are welcome! Feel free to open issues and submit pull requests.

## License
This project is licensed under the MIT License.
