import { browser, by, element, ElementFinder, promise } from 'protractor';

export class AppPage {

  // navigate to home page
  navigateTo() {
    return browser.get('/');
  }

  // get header
  getHeader(): ElementFinder {
    return element(by.css('mat-toolbar'));
  }
  // check header is present or not
  isHeaderPresent(): promise.Promise<boolean> {
    return this.getHeader().isPresent();
  }
}
