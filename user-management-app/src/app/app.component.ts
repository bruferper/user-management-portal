import { Component } from '@angular/core';
import { RouterOutlet, RouterLink } from '@angular/router';
import { NotificationComponent } from './pages/notification/notification.component';
import { RoleComponent } from './role/role.component';
import { HeaderComponent } from './layout/header/header.component';
import { FooterComponent } from './layout/footer/footer.component';

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.scss',
    imports: [RouterOutlet, NotificationComponent, RoleComponent, RouterLink, HeaderComponent, FooterComponent]
})
export class AppComponent {

}
