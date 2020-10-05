<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Contact-List</title>
    <link rel="stylesheet" href="stylesheet.css">
</head>
<body>

<!-- Move the header to a separate file that can be reused -->
<header>
    <h1>Contact List</h1>
</header>

<nav>
    <ul>
    <#list contacts as contact>
        <li>
            <a href="?select=${contact.id}">${contact.name}</a>
        </li>
    </#list>
    </ul>
</nav>

<main>
    <#if selected??>
    <table>
        <tbody>
        <tr>
            <th>Vorname:</th>
            <td>${selected.firstName}</td>
        </tr>
        <tr>
            <th>Nachname:</th>
            <td>${selected.lastName}</td>
        </tr>
        <tr>
            <th>Email:</th>
            <td>${selected.email[0]!"Keine Mail"}</td>
        </tr>
        <tr>
            <th>Phone:</th>
            <td>${selected.phone[0]!}</td>
        </tr>
        </tbody>
    </table>
    <#else>
    <p>Bitte wählen Sie einen Kontakt aus</p>
    </#if>
    <!-- Show the details of the selected contact here -->
</main>

</body>
</html>
