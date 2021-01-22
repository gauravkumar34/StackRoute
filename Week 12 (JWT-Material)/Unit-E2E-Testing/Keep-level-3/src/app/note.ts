export class Note {
  id: Number;
  title: string;
  text: string;
  state: string;

  constructor() {
    this.title = '';
    this.text = '';
    this.state = 'not-started';
  }
}
