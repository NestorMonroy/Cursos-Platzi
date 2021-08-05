ng new profileApp

cd profileApp/

ng g c auth
ng g c profile

---
add amplify and aws-appsync libraries, firstly 
install the amplify cli global and configure it with your AWS account

npm i -g @aws-amplify/cli
amplify configure

npm i --save aws-amplify
npm i --save aws-amplify-angular

polyfills.ts

```ts
(window as any).global = window;
(window as any).process = {browser:true};
```

index.html
```html
  <script>
    if(global === undefined){
      var global = window;
    }
  </script>
```


tsconfig.app.json
```json
{
  "compilerOptions": {
    "types": ["node"]
  },
}

```

amplify init

amplify add auth

amplify add api

amplify push

