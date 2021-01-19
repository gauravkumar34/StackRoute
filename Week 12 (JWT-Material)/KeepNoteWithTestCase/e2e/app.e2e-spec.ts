import { AppPage } from './app.po';

describe('keep App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should display header title', () => {
    page.navigateTo();
    expect(page.isHeaderPresent()).toBeTruthy('<mat-toolbar> should exist in header.component.html');
    expect(page.getHeaderText()).toBe('Keep', '<mat-toolbar> should look like <mat-toolbar>Keep</mat-toolbar>');
  });

  it('should render `Take a note` card', () => {
    page.navigateTo();
    expect(page.isNotePanelPresent()).toBeTruthy('<mat-expansion-panel> should exist');
    expect(page.isNotePanelTitlePresent()).toBeTruthy('<mat-panel-title> should exist');
    page.getNotePanel().click();
    expect(page.getNotePanelTitleText()).toBe('Take a note',
      '<mat-panel-title> should look like <mat-panel-title>Take a note</mat-panel-title>');
    expect(page.isTitleInputBoxPresent()).toBeTruthy('Title input box should exist with name attribute as title');
    expect(page.isTextInputBoxPresent()).toBeTruthy('Text input box should exist with name attribute as text');
    expect(page.isDoneButtonPresent()).toBeTruthy('Done button exists with Done text');
  });

  it('should be able to update title and text in the `Take a note` card', () => {
    page.navigateTo();
    const emptyNoteValues = ['', ''];
    page.getNotePanel().click();
    expect(page.getNotePanelDefaultValues()).toEqual(emptyNoteValues, 'Default values for title and text should be empty');
    const newNoteValues = page.addNoteValues();
    expect(page.getNotePanelDefaultValues()).toEqual(newNoteValues, 'Should be able to set values for note title and text');
    page.clickDoneButton();
  });

});
