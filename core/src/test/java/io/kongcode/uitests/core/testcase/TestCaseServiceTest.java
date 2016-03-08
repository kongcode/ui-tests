package io.kongcode.uitests.core.testcase;

import io.kongcode.uitests.api.TestCase;
import io.kongcode.uitests.api.TestCaseService;
import io.kongcode.uitests.api.dto.TestCaseSearchResult;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by joao on 05/03/16.
 */
public class TestCaseServiceTest {

    private TestCaseService service;
    private TestCaseRepository repository;
    private TestCaseSearchService searchService;

    @Before public void setUp() throws Exception {
        this.repository = mock(TestCaseRepository.class);
        this.searchService = mock(TestCaseSearchService.class);
        this.service = new TestCaseServiceImpl(repository, searchService);
    }

    @Test public void testCreate() throws Exception {
        TestCase entity = TestCase.builder().withId(1).build();
        TestCase.TestCaseBuilder builder = mock(TestCase.TestCaseBuilder.class);
        when(builder.withId(anyInt())).thenReturn(builder);
        when(builder.build()).thenReturn(entity);

        when(repository.insert(entity)).thenReturn(entity.id);
        when(builder.build()).thenReturn(entity);

        assertEquals(entity, service.create(builder));
        verify(repository).insert(entity);
    }

    @Test public void testFindAll() throws Exception {
        int id = 1;
        String name = "Test";
        TestCaseSearchResult testCaseSearchResult = new TestCaseSearchResult(id, name);
        List<TestCaseSearchResult> expected = Arrays.asList(testCaseSearchResult);
        when(searchService.findAll()).thenReturn(expected);
        Iterable<TestCaseSearchResult> actual = service.findAll();
        assertEquals(expected, actual);
        verify(searchService).findAll();
    }
}
