import groovy.json.JsonOutput
import groovy.json.JsonSlurper

class ObjectExposer {
  static Set<String> objectsProcessed = [] as Set<String>

  static String convertObjectToJson(obj, objectRecursive = true, includePrimitiveTypes = false) {
    def excludedTypes = [
            'class java.lang.String',
            'class java.lang.Integer',
            'class java.lang.Boolean',
            'class java.lang.Byte',
            'class java.lang.Short',
            'class java.lang.Long',
            'class java.lang.Float',
            'class java.lang.Double',
            'class java.lang.Character'
    ]

    def json = [:]
    json.value = obj.toString()
    json.classPath = obj.getClass().toString()
    json.methods = [:]
    json.properties = [:]

    if (obj.toString() in objectsProcessed) {
      return JsonOutput.prettyPrint(["Recursive Reference": "Already Processed"])
    } else if (obj == null) {
      return JsonOutput.prettyPrint(["Null Object": "Null Object"])
    } else {
      objectsProcessed << obj.toString()
    }

    obj.metaClass?.methods.each { json.methods[it.name + '()'] = it.toString() }
    obj.properties.each { key, val ->
      if (!key.equals("class")) {
        if (obj.metaClass && obj.getClass()) {
          def vals = [:]
          if (val.toString().contains("ToManyList")) {
            vals["value"] = val.collect {
              if (objectRecursive) {
                if (includePrimitiveTypes || !(it.getClass().toString() in excludedTypes)) {
                  convertObjectToJson(it, includeValue, true, includePrimitiveTypes)
                } else {
                  it.toString()
                }
              } else {
                it.toString()
              }
            }
          } else {
            if (objectRecursive) {
              if (includePrimitiveTypes || !(val.getClass().toString() in excludedTypes)) {
                vals['classDetails'] = [classPath: val.getClass().toString()] + convertObjectToJson(val,  true, includePrimitiveTypes)
              } else {
                vals["value"] = val
                vals["classPath"] = val.getClass().toString()
              }
            } else {
              vals["value"] = val.toString()
            }
          }
          json.properties[key] = vals
        }
      }
    }

    return JsonOutput.prettyPrint(JsonOutput.toJson(json))
  }
}

def slurper = new JsonSlurper()

// Example usage:
def convertedJson = ObjectExposer.convertObjectToJson(slurper, false, false)
return print(convertedJson)
