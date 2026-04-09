FROM amazoncorretto:21

ARG VERSION

COPY target/guestbook-0.0.1-SNAPSHOT.jar /app/guestbook.jar

LABEL title="Guestbook App" \
      version="$VERSION" \
      description="This image is guestbook service"

ENV APP_HOME /app
EXPOSE 8080

WORKDIR $APP_HOME
ENTRYPOINT ["java"]
CMD ["-jar", "guestbook.jar"]
