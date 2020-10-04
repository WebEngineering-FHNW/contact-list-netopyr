package ch.fhnw.webec.contactlist.service;

import ch.fhnw.webec.contactlist.model.ContactDetail;
import ch.fhnw.webec.contactlist.model.ContactOverview;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

@Service
public class ContactService {

    private static final String JSON_FILE = "contacts.json";

    private final ObjectMapper mapper;

    private Map<Long, ContactDetail> contactDetails;
    private List<ContactOverview> contactList;

    @Autowired
    public ContactService(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @PostConstruct
    public void init() throws IOException {
        final List<ContactDetail> contacts = mapper.readValue(ContactService.class.getResource(JSON_FILE), new TypeReference<List<ContactDetail>>() {
        });
        contactDetails = contacts.stream().collect(Collectors.toMap(ContactDetail::getId, identity()));
        contactList = contacts.stream()
                .map(contact -> new ContactOverview(contact.getId(), contact.getLastName() + ", " + contact.getFirstName()))
                .collect(Collectors.toList());
    }

    public List<ContactOverview> getAllContacts() {
        return contactList;
    }

    public Optional<ContactDetail> findContact(long id) {
        return Optional.ofNullable(contactDetails.get(id));
    }
}
