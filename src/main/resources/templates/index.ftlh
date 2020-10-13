<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <title>Contact-List</title>
    <link rel="stylesheet" href="stylesheet.css">
</head>
<body>

<!-- Move the header to a separate file that can be reused -->
<#include "header.ftlh">

<nav>
    <ul>
    <#list contacts as contact>
        <li class="${(selected?? && selected.id == contact.id)?then('selected','')}">
            <a class="contact-link" href="?select=${contact.id}">${contact.name}</a>
        </li>
    </#list>
    </ul>
</nav>

<main>

    <#macro row label id value>
        <tr>
            <th>${label}:</th>
            <td id="${id}-value">${value}</td>
        </tr>
    </#macro>

    <#macro listRow label id values>
        <#list values>
            <tr>
                <th>${label}:</th>
                <td id="${id}-value">
                    <ul>
                        <#items as value><li>${value}</li></#items>
                    </ul>
                </td>
            </tr>
        </#list>
    </#macro>

    <!-- Show the details of the selected contact here -->
    <#if selected??>
    <table id="contact-details">
        <tbody>
        <@row "Vorname" "first-name" selected.firstName/>
        <@row "Nachname" "last-name" selected.lastName/>
        <@listRow "Email" "email" selected.email/>
        <@listRow "Telefon" "phone" selected.phone/>
        <@row "Beruf" "job-title" selected.jobTitle!/>
        <@row "Firma" "company" selected.company!/>
        </tbody>
    </table>
    <#else>
    <p id="no-contact-message">Bitte wählen Sie einen Kontakt aus</p>
    </#if>
</main>

</body>
</html>
