FROM python:3.12.4-alpine3.20

COPY . /app
WORKDIR /app
RUN ls -la
CMD ["python3", "-m", "http.server", "8088"]
