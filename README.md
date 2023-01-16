# Ventera

Ventera is a spring boot library for converting the volume and temperatures.

## Installation

Download this lib and run the below command to start spring boot container.

or

deploy the image in docker hub.
make sure your docker hub credentials are mapped in the secrets file.

```bash
gradlew clean build
```

## Usage

```
curl -X GET http://hostname:port/volume/<input-unit>/<input-value>/<target-unit>
```

```
curl -X GET http://hostname:port/temperature/<input-unit>/<input-value>/<target-unit>
```
