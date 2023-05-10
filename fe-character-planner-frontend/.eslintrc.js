module.exports = {
  env: {
    browser: true,
    es2021: true,
    'jest/globals': true,
  },
  extends: [
    'airbnb-base',
    'airbnb-typescript/base',
    "eslint:recommended",
    'plugin:jest/recommended',
    "plugin:react/recommended",
  ],
  parser: '@typescript-eslint/parser',
  parserOptions: {
    ecmaVersion: 12,
    sourceType: 'module',
    project: './tsconfig.json'
  },
  plugins: [
    '@typescript-eslint',
    "react",
    "jest",
  ],
  rules: {
    '@typescript-eslint/lines-between-class-members': 'off',
    'import/extensions': 'off',
    "jest/expect-expect": [
      "error",
      {
        "assertFunctionNames": ["expect*"]
      }
    ],
    'lines-between-class-members': 'off',
    'max-len': ["error", { "code": 120 }],
  },
  ignorePatterns: ['.eslintrc.js', 'jest.config.js', 'dist/*', 'coverage/*'],
};
