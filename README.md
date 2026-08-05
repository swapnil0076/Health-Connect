# Health Connect

Health Connect is a vaccination registration and appointment-management platform. It combines a Spring Boot REST API with a responsive React frontend for citizens and healthcare teams.

## Current frontend

The frontend has been migrated from the legacy static HTML implementation to Vite + React.

Implemented routes:

- `/` — public Health Connect landing page
- `/login` — secure login experience
- `/signup` — multi-field citizen registration experience
- `/dashboard` — vaccination overview with appointment, family, progress and quick-action cards

The new interface includes responsive layouts for desktop, tablet and mobile, reusable UI patterns, accessible form labels, dashboard states, appointment summaries, vaccination progress, family management entry points and support content.

The React frontend is located in [`frontend/`](frontend/).

## Technology stack

### Frontend

- React 19
- Vite 8
- React Router 7
- CSS with responsive design tokens and reusable component styles

### Backend

- Java 17
- Spring Boot 3
- Spring Web and Spring Security
- Spring Data JPA / Hibernate
- MySQL
- JWT authentication
- SpringDoc OpenAPI

## Run the frontend

```bash
cd frontend
npm install
npm run dev
```

Open [http://localhost:5173](http://localhost:5173).

Create a production build with:

```bash
cd frontend
npm run build
```

## Run the backend

The backend application is in [`arogyasetu/`](arogyasetu/).

```bash
cd arogyasetu
./mvnw spring-boot:run
```

On Windows:

```powershell
cd arogyasetu
.\mvnw.cmd spring-boot:run
```

The API runs on port `8080` and currently expects a local MySQL database named `db1`. Configure credentials in [`application.properties`](arogyasetu/src/main/resources/application.properties).

## Backend modules

- User registration and login
- Member and family-member management
- Vaccine registration
- Appointment booking and updates
- Vaccination-center management
- Vaccine inventory
- Vaccine lookup
- Dose-status tracking

## API integration status

The React UI currently uses realistic mock data for the dashboard and authentication navigation. The next integration step is connecting the React data layer to the Spring Boot endpoints under `/app`, including authentication, member registration, center availability, inventory and appointment booking.

## Project structure

```text
Health-Connect/
├── frontend/       # Vite + React application
├── arogyasetu/      # Spring Boot REST API
└── README.md
```

## Validation

The frontend production build currently passes with `npm run build`.
