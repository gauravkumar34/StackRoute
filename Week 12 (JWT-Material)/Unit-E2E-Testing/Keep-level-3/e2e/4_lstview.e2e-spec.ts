import { ListViewPage } from './page-objects/listview.po';

describe('list view page', () => {
  let page: ListViewPage;
  const emptyNoteValues = ['', ''];
  const editNoteDefaultValues = ['Read Angular 5 blog', 'Shall do at 6 pm', 'not-started'];
  const editNote = ['Read Angular 1 blog', 'Shall do at 10.30 pm', 'not-started'];

  beforeEach(() => {
    page = new ListViewPage();
  });

  it('should render take a note card', () => {
    page.navigateToListView();
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
    page.navigateToListView();
    page.getNotePanel().click();
    expect(page.getNotePanelDefaultValues()).toEqual(emptyNoteValues, 'Default values for title and text should be empty');
    const newNoteValues = page.addNoteValues();
    expect(page.getNotePanelDefaultValues()).toEqual(newNoteValues, 'Should be able to set values for note title and text');
    page.clickDoneButton();
  });

  it('should open edit note model on clicking a note', () => {
    page.navigateToListView();
    page.clickLastNote();
    expect(page.isEditTitleInputBoxPresent()).toBeTruthy('Title input box should exist with name attribute as editTitle');
    expect(page.isEditTextInputBoxPresent()).toBeTruthy('Text input box should exist with name attribute as editText');
    expect(page.isEditStatusInputBoxPresent()).toBeTruthy('Status select box should exist with name attribute as editStatus');
    expect(page.isSaveButtonPresent()).toBeTruthy('Save button exists with Save text');
    expect(page.getLastNoteTitle()).toBe(page.getMockNote().title,
      'Added note title should be shown in <mat-card-title> element on list-view.component.html');
  });

  it('should edit added note', () => {
    page.navigateToListView();
    page.clickLastNote();
    expect(page.isEditTitleInputBoxPresent()).toBeTruthy('Title input box should exist with name attribute as editTitle');
    expect(page.isEditTextInputBoxPresent()).toBeTruthy('Text input box should exist with name attribute as editText');
    expect(page.isEditStatusInputBoxPresent()).toBeTruthy('Status select box should exist with name attribute as editStatus');
    expect(page.isSaveButtonPresent()).toBeTruthy('Save button exists with Save text');
    expect(page.getEditNoteDefaultValues()).toEqual(editNoteDefaultValues, 'Default values should be shown on edit note dialog');
    const editNoteValues = page.editNoteValues();
    expect(page.getEditNoteDefaultValues()).toEqual(editNoteValues, 'Should be able to set values for note title and text');
    page.clickSaveButton();
    expect(page.getLastNoteTitle()).toEqual(editNote[0],
      'Edited note title should be shown in <mat-card-title> element on list-view.component.html');
  });

});
