# Android Unit Test

## build.gradle(Module: app) add a Mockito
>### `dependencies {`
>### ...
>### `testImplementation 'org.mockito:mockito-core:2.8.9'`
>### `testImplementation 'org.>mockito:mockito-inline:2.21.0'`
>`}`

## build.gradle(Module: app) add a Espresso [UI tests]
>### `dependencies {`
>### ...
>### `androidTestImplementation 'com.android.support.test:rules:1.0.2'`
>### `androidTestImplementation 'com.android.support.test:runner:1.0.2'`
>### `androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'`
>`}`

## build.gradle(Module: app) add a Robolectric
## Robolectic[4.3.1 support SDK 29]
>### `dependencies {`
>### ...
>### `testImplementation 'org.robolectric:robolectric:4.3.1'`
>`}`

## Production code
>### app > src > main > java > io > github > xriza

## Instrumented tests、UI tests (Required:Android >= 5.0 and API >= 21)
>### app > src > androidTest > java > io > github > xriza

## Local unit tests
>### app > src > test > java > io > github > xriza