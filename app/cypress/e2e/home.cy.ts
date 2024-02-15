describe('Home', () => {
  beforeEach(() => {
    cy.visit('/')
  });

  it('Visits the initial app page', () => {
    cy.contains('IMS')
  })
})
