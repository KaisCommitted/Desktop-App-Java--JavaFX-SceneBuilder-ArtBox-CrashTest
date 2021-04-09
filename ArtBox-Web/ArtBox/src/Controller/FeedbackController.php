<?php

namespace App\Controller;

use App\Entity\Feedback;
use App\Form\FeedbackType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/feedback")
 */
class FeedbackController extends AbstractController
{
    /**
     * @Route("/", name="feedback_index", methods={"GET"})
     */
    public function index(): Response
    {
        $feedback = $this->getDoctrine()
            ->getRepository(Feedback::class)
            ->findAll();

        return $this->render('feedback/index.html.twig', [
            'feedback' => $feedback,
        ]);
    }

    /**
     * @Route("/new", name="feedback_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $feedback = new Feedback();
        $form = $this->createForm(FeedbackType::class, $feedback);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($feedback);
            $entityManager->flush();

            return $this->redirectToRoute('feedback_index');
        }

        return $this->render('feedback/new.html.twig', [
            'feedback' => $feedback,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idFeedback}", name="feedback_show", methods={"GET"})
     */
    public function show(Feedback $feedback): Response
    {
        return $this->render('feedback/show.html.twig', [
            'feedback' => $feedback,
        ]);
    }

    /**
     * @Route("/{idFeedback}/edit", name="feedback_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Feedback $feedback): Response
    {
        $form = $this->createForm(FeedbackType::class, $feedback);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('feedback_index');
        }

        return $this->render('feedback/edit.html.twig', [
            'feedback' => $feedback,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idFeedback}", name="feedback_delete", methods={"POST"})
     */
    public function delete(Request $request, Feedback $feedback): Response
    {
        if ($this->isCsrfTokenValid('delete'.$feedback->getIdFeedback(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($feedback);
            $entityManager->flush();
        }

        return $this->redirectToRoute('feedback_index');
    }
}
