<?php

namespace App\Controller;

use App\Entity\CommentEvent;
use App\Form\CommentEventType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/comment/event")
 */
class CommentEventController extends AbstractController
{
    /**
     * @Route("/", name="comment_event_index", methods={"GET"})
     */
    public function index(): Response
    {
        $commentEvents = $this->getDoctrine()
            ->getRepository(CommentEvent::class)
            ->findAll();

        return $this->render('comment_event/index.html.twig', [
            'comment_events' => $commentEvents,
        ]);
    }

    /**
     * @Route("/new", name="comment_event_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $commentEvent = new CommentEvent();
        $form = $this->createForm(CommentEventType::class, $commentEvent);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($commentEvent);
            $entityManager->flush();

            return $this->redirectToRoute('comment_event_index');
        }

        return $this->render('comment_event/new.html.twig', [
            'comment_event' => $commentEvent,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="comment_event_show", methods={"GET"})
     */
    public function show(CommentEvent $commentEvent): Response
    {
        return $this->render('comment_event/show.html.twig', [
            'comment_event' => $commentEvent,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="comment_event_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, CommentEvent $commentEvent): Response
    {
        $form = $this->createForm(CommentEventType::class, $commentEvent);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('comment_event_index');
        }

        return $this->render('comment_event/edit.html.twig', [
            'comment_event' => $commentEvent,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="comment_event_delete", methods={"POST"})
     */
    public function delete(Request $request, CommentEvent $commentEvent): Response
    {
        if ($this->isCsrfTokenValid('delete'.$commentEvent->getId(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($commentEvent);
            $entityManager->flush();
        }

        return $this->redirectToRoute('comment_event_index');
    }
}
