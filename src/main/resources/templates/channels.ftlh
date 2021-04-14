<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>CHANNELS</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="inputForm.css">
</head>
<body>
<form action="/" method="get">
    <div>
        <button type="submit">HOME</button>
    </div>
</form>
<div class="container">
    <form action="/channels" method="post">
        <div class="row">
            <div class="col-25">
                <label for="channelName"> Name </label>
            </div>
            <div class="col-75">
                <select id="channelName" name="channelName">
                    <option>...</option>
                    <#list channels as channel>
                        <option>${channel.name}</option>
                    </#list>
                </select>
            </div>
        </div>

        <#if channel??>
            <div class="row">
                <div class="col-25">
                    <label for="type">Type:</label>
                </div>
                <div class="col-75">
                    <select name="type" id="type">
                        <option>${channel.type.name()}</option>
                        <#list types as type>
                            <#if type != channel.type.name()>
                                <option>${type}</option>
                            </#if>
                        </#list>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="satellites"> Satellites: </label>
                </div>
                <div class="col-75">
                    <input type="text" value="
<#list channel.satellites as satellite>
                        ${satellite.name}/
                        </#list>
">

                </div>
            </div>




            <label> Frequency: <input type="text" placeholder="${channel.frequency}"></label>

            <label> Flow rate: <input type="text" placeholder="${channel.flowRate}"></label>

            <label> Polarization:
                <select>
                    <option>${channel.polarization.name()}</option>
                    <#list polarizations as polarization>
                        <#if polarization != channel.polarization.name()>
                            <option>${polarization}</option>
                        </#if>
                    </#list>
                </select>
            </label>

            <label> Encoding:
                <select>
                    <option>${channel.encoding.name()}</option>
                    <#list encodings as encoding>
                        <#if encoding != channel.encoding.name()>
                            <option>${encoding}</option>
                        </#if>
                    </#list>
                </select>
            </label>

            <label> Language:
                <#list channel.languages as language>
                ${language.caption.name()}<p>
                    </#list>
            </label>

            <label> Country:
                <select>
                    <option>${channel.country.name()}</option>
                    <#list countries as country>
                        <#if country != channel.country.name()>
                            <option>${country}</option>
                        </#if>
                    </#list>
                </select>
            </label>

            <label> Began: ${channel.broadcastBegan}</label>

            <label> Confirmed: ${channel.broadcastConfirmed}</label>

            <label> Broadcasted:
                <#if channel.isBroadcasted() == true>
                    YES
                <#else>
                    NO
                </#if>
            </label>

            <label> Description:
                <#if channel.description??>
                    <input type="text" placeholder="${channel.description}" name="description">
                </#if>
            </label>
        </#if>
        <div class="row">
            <input type="submit" value="SUBMIT">
        </div>
    </form>
</div>
</body>
</html>