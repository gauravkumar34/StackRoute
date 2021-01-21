import { browser, by, element, ElementFinder, promise, ElementArrayFinder } from 'protractor';

export class DashboardViewPage {

  // navigate to dashboard view page
  navigateToDashboardView() {
    return browser.get('/dashboard');
  }

  // to pause browser
  pauseBrowser(port) {
    browser.pause(port);
  }

  // app component
  getAppComponent(): ElementFinder {
    return element(by.tagName('app-root'));
  }
  // get note panel title element
  getNotePanelTitle(): ElementFinder {
    return element(by.css('mat-panel-title'));
  }

  // check note panel title element is present or not
  isNotePanelTitlePresent(): promise.Promise<boolean> {
    return this.getNotePanelTitle().isPresent();
  }

  // get note panel title element value
  getNotePanelTitleText() {
    return this.getNotePanelTitle().getText();
  }

  // get complete note panel
  getNotePanel(): ElementFinder {
    return element(by.css('mat-expansion-panel'));
  }

  // check note panel is present or not
  isNotePanelPresent(): promise.Promise<boolean> {
    return this.getNotePanel().isPresent();
  }

  // get title input box
  getTitleInputBox(): ElementFinder {
    return element(by.name('title'));
  }

  // check title input box is present or not
  isTitleInputBoxPresent(): promise.Promise<boolean> {
    return this.getTitleInputBox().isPresent();
  }

  // get text input box
  getTextInputBox(): ElementFinder {
    return element(by.name('text'));
  }

  // check text input box is present or not
  isTextInputBoxPresent(): promise.Promise<boolean> {
    return this.getTextInputBox().isPresent();
  }

  // get button
  getDoneButton(): ElementFinder {
    return this.getAppComponent().element(by.buttonText('Done'));
  }

  // check button is present or not
  isDoneButtonPresent(): promise.Promise<boolean> {
    return this.getDoneButton().isPresent();
  }

  // click done button
  clickDoneButton(): promise.Promise<void> {
    return this.getDoneButton().click();
  }

  // get note panel default values
  getNotePanelDefaultValues(): any {
    let inputTitle, inputText;
    inputTitle = this.getTitleInputBox().getAttribute('value');
    inputText = this.getTextInputBox().getAttribute('value');
    return Promise.all([inputTitle, inputText]).then( (values) => {
      return values;
    });
  }

  // get note data
  getMockNote(): any {
    const note: any = { title: 'Read Angular 5 blog', text : 'Shall do at 6 pm'};
    return note;
  }

  // set input fileds values with mock data
  addNoteValues(): any {
    const newNote: any = this.getMockNote();
    this.getTitleInputBox().sendKeys(newNote.title);
    this.getTextInputBox().sendKeys(newNote.text);
    return Object.keys(newNote).map(key => newNote[key]);
  }

  // get all notes
  getAllNotes(): ElementArrayFinder {
    return element.all(by.css('mat-card'));
  }
  // get last note
  getLastNote(): ElementFinder {
    return this.getAllNotes().last();
  }

  // get last note
  getLastNoteTitle(): promise.Promise<string> {
    return this.getAllNotes().last().element(by.css('mat-card-title')).getText();
  }
}
