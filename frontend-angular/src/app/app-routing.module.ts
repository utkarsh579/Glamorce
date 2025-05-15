import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CartServiceComponent } from './cart-service/cart-service.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { PaymentServiceComponent } from './payment-service/payment-service.component';
import { NavigationBarComponent } from './navigation-bar/navigation-bar.component';
import { RecommendationComponent } from './recommendation/recommendation.component';
import { OrderListComponent } from './order-list/order-list.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { ProfileComponent } from './profile/profile.component';
import { AppointmentServiceComponent } from './appointment-service/appointment-service.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { SalonServicesComponent } from './salon-services/salon-services.component';
import { EmployeeDashboardComponent } from './employee-dashboard/employee-dashboard.component';
import { HomeComponent } from './home/home.component';
import { AddServiceComponent } from './add-service/add-service.component';
import { CreateSlotsComponent } from './create-slots/create-slots.component';
import { AdminGuardGuard } from './guards/admin-guard.guard';
import { UserGuardGuard } from './guards/user-guard.guard';


const routes: Routes = [
  {path:"",component:HomeComponent},
  {path:"home",component:HomeComponent},
  {path:"cart",component:CartServiceComponent},
  {path:"loginView",component:LoginComponent},
  {path:"register",component:RegisterComponent},
  {path:"registerEmployee",component:AddEmployeeComponent},
  {path:"recommendation",component:RecommendationComponent}, 
  {path:"orders",component:OrderListComponent},
  {path:"payment",component:PaymentServiceComponent},
  {path:"navigation-bar",component:NavigationBarComponent},
  {path:"feedback/:id", component:FeedbackComponent},
  {path:"adminDashboard", component:EmployeeDashboardComponent},
  {path:"profile", component:ProfileComponent},
  {path:"appointment-service/:serviceId",component:AppointmentServiceComponent},
  {path:"service",component:SalonServicesComponent},
  {path:"add-employee",component:AddEmployeeComponent},
  {path:"add-services",component:AddServiceComponent},
  {path:"salon-services",component:SalonServicesComponent},
  {path:"create-slots/:id",component:CreateSlotsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
