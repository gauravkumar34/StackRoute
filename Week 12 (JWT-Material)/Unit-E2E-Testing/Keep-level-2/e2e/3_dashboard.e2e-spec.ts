import { DashboardViewPage } from './page-objects/dashboard.po';

describe('dashboard page', () => {
  let page: DashboardViewPage;
  const emptyNoteValues = ['', ''];

  beforeEach(() => {
    page = new DashboardViewPage();
  });

  it('should render take a note card', () => {
    page.navigateToDashboardView();
    expect(page.isNotePanelPresent()).toBeTruthy('<mat-expansion-panel> should exist');
    expect(page.isNotePanelTitlePresent()).toBeTruthy('<mat-panel-title> should exist');
    page.getNotePanel().click();
    expect(page.getNotePanelTitleText()).toEqual('Take a note',
      '<mat-panel-title> should look like <mat-panel-title>Take a note</mat-panel-title>');
    expect(page.isTitleInputBoxPresent()).toBeTruthy('Title input box should exist with name attribute as title');
    expect(page.isTextInputBoxPresent()).toBeTruthy('Text input box should exist with name attribute as text');
    expect(page.isDoneButtonPresent()).toBeTruthy('Done button exists with Done text');
  });

  it('should create a note', () => {
    page.navigateToDashboardView();
    page.getNotePanel().click();
    expect(page.getNotePanelDefaultValues()).toEqual(emptyNoteValues, 'Default values for title and text should be empty');
    const newNoteValues = page.addNoteValues();
    expect(page.getNotePanelDefaultValues()).toEqual(newNoteValues, 'Should be able to set values for note title and text');
    page.clickDoneButton();
  });
});
