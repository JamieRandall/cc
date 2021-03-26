CREATE TABLE "User" (
    "user_id" long   NOT NULL,
    "name" varchar(50)   NOT NULL,
    "password" varchar(100)   NOT NULL,
    CONSTRAINT "pk_User" PRIMARY KEY (
        "user_id"
     )
);

CREATE TABLE "Channel" (
    "channel_id" long   NOT NULL,
    "name" varhar(50)   NOT NULL,
    "frequency" float   NOT NULL,
    "polarization_value" float   NOT NULL,
    CONSTRAINT "pk_Channel" PRIMARY KEY (
        "channel_id"
     )
);

CREATE TABLE "Satellite" (
    "satellite_id" long   NOT NULL,
    "name" varchar(50)   NOT NULL,
    "description" varchar(50)   NOT NULL,
    CONSTRAINT "pk_Satellite" PRIMARY KEY (
        "satellite_id"
     )
);

CREATE TABLE "Channels_satellites" (
    "channel_id" long   NOT NULL,
    "satellite_id" long   NOT NULL
);

CREATE TABLE "Refresh" (
    "user_id" long   NOT NULL,
    "channel_id" long   NOT NULL,
    "change_time" timestamp   NOT NULL
);

ALTER TABLE "Channels_satellites" ADD CONSTRAINT "fk_Channels_satellites_channel_id" FOREIGN KEY("channel_id")
REFERENCES "Channel" ("");

ALTER TABLE "Channels_satellites" ADD CONSTRAINT "fk_Channels_satellites_satellite_id" FOREIGN KEY("satellite_id")
REFERENCES "Satellite" ("");

ALTER TABLE "Refresh" ADD CONSTRAINT "fk_Refresh_user_id" FOREIGN KEY("user_id")
REFERENCES "User" ("");

ALTER TABLE "Refresh" ADD CONSTRAINT "fk_Refresh_channel_id" FOREIGN KEY("channel_id")
REFERENCES "Channel" ("");

