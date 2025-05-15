import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './login/login.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import { HttpClientModule } from '@angular/common/http';
import { RegisterComponent } from './register/register.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import { FeedbackComponent } from './feedback/feedback.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule, MatRippleModule } from '@angular/material/core';
import { CreateSlotsComponent } from './create-slots/create-slots.component';
import {MatRadioModule} from '@angular/material/radio';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatSelectModule} from '@angular/material/select';
import { EmployeeCardComponent } from './employee-card/employee-card.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatTooltipModule} from '@angular/material/tooltip';
import { CartServiceComponent } from './cart-service/cart-service.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { AppointmentServiceComponent } from './appointment-service/appointment-service.component';
import { PaymentServiceComponent } from './payment-service/payment-service.component';
import { NavigationBarComponent } from './navigation-bar/navigation-bar.component';
import { RecommendationComponent } from './recommendation/recommendation.component';
import { OrderListComponent } from './order-list/order-list.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { SalonServicesComponent } from './salon-services/salon-services.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatTableModule } from '@angular/material/table';
import { ObserversModule } from '@angular/cdk/observers';
import { ProfileComponent } from './profile/profile.component';
import { ManageAddressesComponent } from './manage-addresses/manage-addresses.component';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatDividerModule} from '@angular/material/divider';
import {MatListModule} from '@angular/material/list';
import {MatMenuModule} from '@angular/material/menu';
import {MatCardModule} from '@angular/material/card';
import { EmployeeDashboardComponent } from './employee-dashboard/employee-dashboard.component';
import {MatIconModule} from '@angular/material/icon';
import {MatGridListModule} from '@angular/material/grid-list';
import { LettersAvatarModule } from "ngx-letters-avatar";
import { HomeComponent } from './home/home.component';
import { AddServiceComponent } from './add-service/add-service.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { EmployeesSlotsComponent } from './employees-slots/employees-slots.component';
import { EmployeesComponent } from './employees/employees.component';






@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    FeedbackComponent,
    CreateSlotsComponent,
    AppointmentServiceComponent,
    PaymentServiceComponent,
    NavigationBarComponent,
    EmployeeCardComponent,
    EmployeeDashboardComponent,
    EmployeeListComponent,
    AddEmployeeComponent,
    RecommendationComponent,
    SalonServicesComponent,
    ProfileComponent,
    ManageAddressesComponent,
    OrderListComponent,
    CartServiceComponent,
    HomeComponent,
    AddServiceComponent,
    EmployeesSlotsComponent,
    EmployeesComponent
  ],
  imports: [
    NgxPaginationModule,
    LettersAvatarModule,
    MatIconModule,
    MatExpansionModule,
    ObserversModule,
    BrowserModule,
    MatMenuModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatTableModule,
    MatRadioModule,
    MatInputModule,
    MatNativeDateModule,
    ReactiveFormsModule,
    MatGridListModule,
    FormsModule,
    HttpClientModule,
    MatSnackBarModule,
    NgbModule,
    MatDatepickerModule,
    MatRadioModule,
    MatCheckboxModule,
    MatToolbarModule,
    MatSelectModule,
    MatRippleModule,
    MatPaginatorModule,
    MatTooltipModule,
    MatButtonModule,
    MatSnackBarModule,
    MatToolbarModule,
    MatNativeDateModule,
    MatExpansionModule,
    MatDividerModule,
    MatListModule,
    MatCardModule,
    Ng2SearchPipeModule,
    NgbModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
