import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PeopleService } from '../people.service';
import { NavigationService } from '../navigation.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css'],
})
export class DetailsComponent implements OnInit {
  search: any = [];
  searchresults: any = [];

  constructor(
    private route: ActivatedRoute,
    private service: PeopleService,
    private navigation: NavigationService
  ) {}

  async ngOnInit(): Promise<void> {
    this.route.queryParams.subscribe(async (params: any) => {
      this.search = await this.service.searchPerson(params.search);
      this.searchresults = this.search.results;
    });
  }

  back(): void {
    this.navigation.back();
  }
}
