describe('Items', () => {

  beforeEach(() => {
    cy.visit('/inventory')
  });

  /*it('add button should exist', () => {
    cy.get('#add').should('exist');
  });*/

  /*it('should add a new item', () => {
    cy.get('#add').click();
    cy.get('#name').type('Test Item');
    cy.get('#save').click();
    cy.get('.alert-success').should('exist');
  });

  it('should edit a item', () => {
    cy.get('a').last().click();
    cy.get('#name').should('have.value', 'Test Item');
    cy.get('#cancel').click();
  });

  it('should delete a item', () => {
    cy.get('button').last().click();
    cy.on('window:confirm', () => true);
    cy.get('.alert-success').should('exist');
  });*/
});
