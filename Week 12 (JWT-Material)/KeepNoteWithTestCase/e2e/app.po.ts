import { browser, by, element, ElementFinder, promise } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get('/');
  }

  // app component
  getAppComponent(): ElementFinder {
    return element(by.tagName('app-root'));
  }

  // toolbar section
  getHeader(): ElementFinder {
    return element(by.css('mat-toolbar'));
  }

  isHeaderPresent(): promise.Promise<boolean> {
    return this.getHeader().isPresent();
  }
  getHeaderText() {
    return this.getHeader().getText();
  }

  // notepaneltitle section
  getNotePanelTitle(): ElementFinder {
    return element(by.css('mat-panel-title'));
  }

  isNotePanelTitlePresent(): promise.Promise<boolean> {
    return this.getNotePanelTitle().isPresent();
  }

  getNotePanelTitleText() {
    return this.getNotePanelTitle().getText();
  }

  // note panel root
  getNotePanel(): ElementFinder {
    return element(by.css('mat-expansion-panel'));
  }

  isNotePanelPresent(): promise.Promise<boolean> {
    return this.getNotePanel().isPresent();
  }

  // input box
  getTitleInputBox(): ElementFinder {
    return element(by.name('title'));
  }

  isTitleInputBoxPresent(): promise.Promise<boolean> {
    return this.getTitleInputBox().isPresent();
  }

  // text area
  getTextInputBox(): ElementFinder {
    return element(by.name('text'));
  }

  isTextInputBoxPresent(): promise.Promise<boolean> {
    return this.getTextInputBox().isPresent();
  }

  // button
  getDoneButton(): ElementFinder {
    return this.getAppComponent().element(by.buttonText('Done'));
  }

  isDoneButtonPresent(): promise.Promise<boolean> {
    return this.getDoneButton().isPresent();
  }

  clickDoneButton(): promise.Promise<void> {
    return this.getDoneButton().click();
  }

  getNotePanelDefaultValues(): any {
    let inputTitle, inputText;
    inputTitle = this.getTitleInputBox().getAttribute('value');
    inputText = this.getTextInputBox().getAttribute('value');
    return Promise.all([inputTitle, inputText]).then( (values) => {
      return values;
    });
  }

  getMockNote(): any {
    const note: any = { title: 'Read Angular 5 blog', text : 'Shall do at 6 pm'};
    return note;
  }

  addNoteValues(): any {
    const newNote: any = this.getMockNote();
    this.getTitleInputBox().sendKeys(newNote.title);
    this.getTextInputBox().sendKeys(newNote.text);
    return Object.keys(newNote).map(key => newNote[key]);
  }
}
