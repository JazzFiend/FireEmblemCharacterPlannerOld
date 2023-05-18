# Testing

## Mutation Testing

Run this command for Mutation Tests:
- Including Acceptance Tests: `mvn test-compile org.pitest:pitest-maven:mutationCoverage`
- Just Unit Tests: `mvn test-compile org.pitest:pitest-maven:mutationCoverage -DtargetTests='com.pd.fe_character_planner.*'`