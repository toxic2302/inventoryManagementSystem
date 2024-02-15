import { defineConfig } from 'cypress'

export default defineConfig({

  projectId: "dtn8po",

  e2e: {
    'baseUrl': 'http://localhost:4200'
  },


  component: {
    devServer: {
      framework: 'angular',
      bundler: 'webpack',
    },
    specPattern: '**/*.cy.ts'
  }

})
