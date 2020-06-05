# Android Unit Test
## Production code
>### app > src > main > java > io > github > xriza

## Instrumented tests、UI tests (Required:Android >= 5.0 and API >= 21)
>### app > src > androidTest > java > io > github > xriza

## Local unit tests
>### app > src > test > java > io > github > xriza

## build.gradle(Module: app) add a Mockito
>### `dependencies {`
>### ...
>### `testImplementation 'org.mockito:mockito-core:2.8.9'`
>### `testImplementation 'org.>mockito:mockito-inline:2.21.0'`
>`}`