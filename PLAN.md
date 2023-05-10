# Overview

This will replace the spreadsheets used to plan out a Fire Emblem run. Users can see characters' stats and skills and use that to select who to use for a given run. The user can map weapons and weapon types to characters. They can designate core team members and ancillary team members. USers should be able to save the state of their team and retrieve it later.

Since this is meant to be a training exercise for me, I want to have a front end and back end system. The back end will be an API that stores and sends all information about the games and the characters. It will also get the state of the current team and save it. The front end will use the backend to get all relevant information, show this information via the UI, and keep track of the current team. 

# Open Tech Debt

- Jest is failing on VSCode startup because the Node version is incorrect.
- Local Port Addresses conflict a lot.
- Reach.DOM error in React18
- ts-jest is conflicting with the typescript version.
- Mocking API calls isn't working. The promise never gets resolved. I'm putting this away for now to move on to other things. Look into Mock Service Worker to help.
- As a result of the last one, the frontend has no tests yet.
- Frontend Lint issues - webpack needs to be reinstalled.