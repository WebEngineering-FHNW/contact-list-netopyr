<!DOCTYPE html>
<html lang="en">
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
        <li>
            <a class="contact-link" href="?select=${contact.id}">${contact.name}</a>
        </li>
    </#list>
    </ul>
</nav>

<main>

    <#macro row label value>
        <tr>
            <th>${label}:</th>
            <td>${value}</td>
        </tr>
    </#macro>

    <#if selected??>
    <table id="contact-details">
        <tbody>
        <@row "Vorname" selected.firstName/>
        <@row "Nachname" selected.lastName/>
        <@row "Email" selected.email[0]!"Keine Mail"/>
        <@row "Telefon" selected.phone[0]!/>
        </tbody>
    </table>
    <#else>
    <p id="no-contact-message">Bitte wählen Sie einen Kontakt aus</p>
    </#if>
    <!-- Show the details of the selected contact here -->
</main>

</body>
</html>
