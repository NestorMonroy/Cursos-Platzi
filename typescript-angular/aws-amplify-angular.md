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


main.ts
```ts
import Amplify from 'aws-amplify';
import amplify from './aws-exports';

```

app.module.ts
```ts
import {AmplifyAngularModule, AmplifyService} from 'aws-amplify-angular';

@NgModule({
  imports: [
    AmplifyAngularModule
  ],
  providers: [AmplifyService],
})


```

app-routing.module.ts
```ts

import { AuthComponent } from './auth/auth.component';
import { ProfileComponent } from './profile/profile.component';


const routes: Routes = [
  {
    path: 'profile',
    component: ProfileComponent,
  },
  {
    path: 'login',
    component: AuthComponent
  },
  {
    path: '**',
    redirectTo: 'login',
    pathMatch: 'full',
  },
];


```
auth.component.html

```html
<amplify-authenticator >
  <!-- <amplify-auth-sign-in header-text="My Custom Sign Up Text" slot="sign-up"></amplify-auth-sign-in> -->
</amplify-authenticator>
```

app.component.html

```html
<router-outlet></router-outlet>
```

styles.sass
```scss
@import '~aws-amplify-angular/theme.css';
```


ng serve