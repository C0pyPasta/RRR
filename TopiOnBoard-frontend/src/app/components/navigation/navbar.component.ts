import { Component } from '@angular/core';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavBarComponent {
  indicator = document.querySelector('#indicator');
  items = document.querySelectorAll('nav a');

  marker(e) {
    this.indicator!.style.left = e.offsetLeft+"px";
    this.indicator.style.width = e.offsetWidth+"px";
  }

items.forEach(link => {
    link.addEventListener('click', (e) => {
        marker(e.target);
    })
})
}
